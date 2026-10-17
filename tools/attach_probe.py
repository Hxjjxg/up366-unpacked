import frida, sys, json

dev = frida.get_device_manager().add_remote_device("127.0.0.1:27042")
print("device:", dev, dev.name)
procs = dev.enumerate_processes()
print("procs:", [(p.pid, p.name) for p in procs][:10])
sess = dev.attach("Gadget")
print("attached")
script = sess.create_script("""
rpc.exports = {
  info: function () {
    return {
      arch: Process.arch,
      pointerSize: Process.pointerSize,
      modules: Process.enumerateModules().length,
      ranges: Process.enumerateRanges('r--').length,
      java: (typeof Java !== 'undefined')
    };
  }
};
""")
script.load()
print(json.dumps(script.exports_sync.info()))
sess.detach()
print("detached")
