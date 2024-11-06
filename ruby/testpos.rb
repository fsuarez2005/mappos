#!/usr/bin/env ruby

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