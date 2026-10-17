# up366 (com.up366.mobile) 脱壳产物

天学网 Android 客户端 `com.up366.mobile` 百度加固的内存 DEX dump 与反编译源码。

## 目标信息

| 项 | 值 |
|---|---|
| 包名 | `com.up366.mobile` |
| 版本 | 6.0.1 (versionCode 220)，minSdk 23 / targetSdk 31 |
| 测试设备 | PGJM10 (OP5297)，Android 13，arm64-v8a，KernelSU root |
| 原始 APK | `base.apk`，231,432,870 bytes（SHA-256 见 `metadata/dex_manifest.json` 同级说明） |
| APK 内文件时间 | 2026-09-28 |

## 加固识别

**百度加固（Baidu Protect）**

| 证据 | 内容 |
|---|---|
| Manifest Application | `com.sagittarius.v6.StubApplication` |
| Native 库 | `lib/arm64-v8a/libbaiduprotect.so` (477 KB) |
| Assets | `assets/baiduprotect1~6.jar`、`baiduprotect*.i.dex`、`baiduprotect-sec.dex` |
| 静态 DEX | APK 内 6 个 `classes*.dex`（约 30 MB）仅含壳、SDK 与桩代码 |

- 静态 DEX 中 `com/up366/mobile/` 业务类几乎不存在，业务代码为运行时解密
- 真实 Application：`com.up366.mobile.Up366Application`
- 启动链：`com.up366.mobile.SplashActivity` (MAIN/LAUNCHER) → `com.up366.mobile.main.MainActivity`

## 脱壳环境

- 注入：ZygiskFrida（`/data/adb/modules/zygiskfrida/zygisk/arm64-v8a.so`）
- 连接：`adb forward tcp:27042 tcp:27042`，Frida Gadget 监听 27042
- 工具：frida 16.7.19 + frida-dexdump，host = Windows

## 产物结构

```
.
├── dex/                          # 3 个有效业务 DEX（未重命名前的对应关系见下）
│   ├── classes.dex               # 来自 dump/classes09.dex
│   ├── classes2.dex              # 来自 dump/classes11.dex
│   └── classes3.dex              # 来自 dump/classes15.dex
├── decompiled/sources/           # jadx 1.5.5 反编译源码
│   └── ...                       # 3939 个 .java，约 35 MB
├── metadata/
│   ├── AndroidManifest.xmltree.txt   # aapt2 导出的完整 Manifest 树（986 行）
│   └── dex_manifest.json             # DEX 大小/class_defs/校验和
└── tools/
    ├── verify_dex.py             # DEX 头校验与去重脚本
    └── attach_probe.py           # Frida Gadget 最小 attach 探测脚本
```

## DEX 清单

| 文件 | 大小 | class_defs | strings | adler32 | SHA-256 |
|---|---|---|---|---|---|
| `dex/classes.dex` | 5,229,716 | 4,480 | 46,959 | 通过 | `784c41ed…a2d9` |
| `dex/classes2.dex` | 4,199,356 | 3,890 | 34,218 | 通过 | `ee824fd7…2368` |
| `dex/classes3.dex` | 1,329,900 | 1,273 | 12,016 | 通过 | `49827eb1…4d4c` |

合计 9,643 个 class_defs，完整覆盖 `com.up366.*` 业务类。
完整校验值见 `metadata/dex_manifest.json`。

## 反编译

- 工具：jadx 1.5.5 (CLI)
- 顶层类 2,440 个，输出 3,939 个 `.java` 文件
- 反编译错误 4 个（混淆/畸形方法体），其余可读
- 关键类：
  - `com/up366/mobile/Up366Application.java` — 真实 Application
  - `com/up366/mobile/main/MainActivity.java` — 主界面
  - `com/up366/mobile/SplashActivity.java` — 启动页
  - `com/up366/common/http/` — OkHttp/Cookie/DNS 网络栈
  - `com/up366/mobile/common/utils/HmacSHA1Signature.java` — 签名工具

## 复现命令

```bash
# 1. 拉取 APK
adb pull /data/app/~~7RWEFWQML9bNduv0icfbhw==/com.up366.mobile-_QFYb-wlMKSoFimFgXdTDg==/base.apk

# 2. 保持 App 在前台，深度扫描 dump
frida-dexdump -H 127.0.0.1:27042 -n Gadget -o dump -d

# 3. 校验并挑选有效 DEX
python tools/verify_dex.py

# 4. 反编译
java -cp "F:/jadx/lib/jadx-gui-1.5.5-all.jar" jadx.cli.JadxCLI -d jadx_full \
  --no-res --no-imports dump/classes09.dex dump/classes11.dex dump/classes15.dex
```

## 注意事项

- **App 必须在前台**才能 attach/dump。切到后台后进程被系统冻结，Frida attach 会无限卡住（已实际复现）。
- frida-dexdump 原始输出为 86 个内存片段，需按 DEX 头 adler32 去重。
- 内存中相邻的 `classes09 + classes11` 会被合并成一个 9.4 MB 的伪 DEX（`classes10.dex`），无法直接加载，已按内嵌 magic 拆分排除。
- `classes12/13/14/16` 等为同一 DEX 的加密/quickened 副本，经类名集合比对无任何新增业务类，已排除。
- 当前产物覆盖 App 启动及已访问页面加载的模块；如需更多动态模块，导航到对应页面后重新 dump。
