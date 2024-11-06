#!/usr/bin/env ruby


# LOOP: get input from user
# determine type of user input
# if UPC, push onto current transaction, goto LOOP
# else if "Done", goto FINISHTRANSACTION
# else, print "Command not found."

def get_input
  
  return 1
end



def main_loop
  while true
    user_input = (gets).chomp
    p user_input
  end
  
end


def main
  puts "Hello"
  main_loop
end

main