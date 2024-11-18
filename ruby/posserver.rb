#!/usr/bin/env ruby

# TODO: List 
# [] command list
# [] transaction process
# [] 

require 'socket'

def process_connection
end


def simple_server_loop
  server = TCPServer.open(2000)
  puts "Server: #{server.addr}"
  
  
  loop {
    client, client_address = server.accept
    puts "New connection from #{client.peeraddr}"
    
    client.puts "Hello, #{client.peeraddr}. This is #{client.addr}."

    client.close
  }
  
end

def main
  simple_server_loop
  
end

main