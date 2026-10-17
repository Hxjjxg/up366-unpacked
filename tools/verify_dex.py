import os, struct, hashlib, glob

rows = []
for p in sorted(glob.glob(r"E:\up366_re\dump\*.dex")):
    data = open(p, "rb").read()
    magic = data[:8]
    if len(data) < 0x70 or not magic.startswith(b"dex\n"):
        rows.append((os.path.basename(p), "BADMAGIC", len(data), 0, 0, 0, ""))
        continue
    file_size, header_size = struct.unpack_from("<II", data, 0x20)
    checksum = struct.unpack_from("<I", data, 0x8)[0]
    string_ids_size = struct.unpack_from("<I", data, 0x38)[0]
    class_defs_size = struct.unpack_from("<I", data, 0x60)[0]
    status = "OK" if len(data) == file_size else f"SIZE_MISMATCH(actual={len(data)},header={file_size})"
    rows.append((os.path.basename(p), status, len(data), class_defs_size, string_ids_size, checksum, magic.decode('latin1').strip('\x00')))

seen = {}
for r in rows:
    name, status, size, classes, strs, csum, magic = r
    if status != "OK":
        print(f"{name:18} {status} magic={magic!r}")
        continue
    key = (csum, size)
    seen.setdefault(key, []).append((name, classes, strs))

print("\n=== unique valid dex (by checksum) ===")
for (csum, size), files in sorted(seen.items(), key=lambda kv: -kv[0][1]):
    names = ",".join(f[0] for f in files)
    classes = files[0][1]; strs = files[0][2]
    print(f"size={size:9} classes={classes:6} strings={strs:7} files={names}")
print("\nunique dex count:", len(seen), " total files:", len(rows))
