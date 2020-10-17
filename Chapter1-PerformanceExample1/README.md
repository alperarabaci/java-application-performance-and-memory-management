## JIT

java -XX:+PrintCompilation main.Main 5000
java -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation main.Main 5000
java -XX:+PrintCodeCache main.Main 5000
java -XX:ReservedCodeCacheSize=28m -XX:+PrintCodeCache main.Main 5000
java -XX:CICompilerCount=6  -XX:+PrintCompilation  main.Main 5000