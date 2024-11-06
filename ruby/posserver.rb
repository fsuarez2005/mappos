#!/usr/bin/env ruby

require 'socket'


def simple_server_loop
  server = TCPServer.open(2000)
  
  loop {
    client = server.accept
    puts "New connection"
    
    client.puts "Hello"

    client.close
  }
  
end

def main
  simple_server_loop
  
end

main