def list = ['John Doe', 'Richard Miles']     

list.each{ item ->
	println item
}                



def c = {item -> println item}
list.each(c)
      