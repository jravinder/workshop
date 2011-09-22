def s = 'John'        

String.metaClass.hello = { -> "Hello ${delegate}!" }   

println s.hello()