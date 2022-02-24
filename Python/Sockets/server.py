
# Importing the libraries required to build the server.
import socket
import sys
import os

# Using a utility file to import a function.
from utility import send_file, recv_file, send_listing


try:
    # Create a socket for the server to accept new connections.
    Server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    Server.bind(("", int(sys.argv[1])))

    Server.listen(5)

# The server will receive this massage.
    print("Waiting... ")

# accept return a tuple; this breaks the tuple down into two variables.
    Client, ClientAddress = Server.accept()

# Convert the client IP to a string.
    ClientIPString = str(ClientAddress)

# The IP and PORT will be displayed on the server when the client connects.
    print("Client IP: " + ClientIPString + " " + "PORT: " + sys.argv[1])

# Get a datasterm from the client.
    CmdList = Client.recv(1024)
    cmd = CmdList.decode().split(" ", 1)

# If the client requests a list, the server will show the files in the server_data folder.
    if (cmd[0] == "list"):
        send_listing(Client)

    else:
        Text = cmd[1]
        FileName = os.path.join(os.path.dirname(
            __file__), "server_data/") + Text

        if (cmd[0] == "put"):
            recv_file(FileName, Client)
        elif (cmd[0] == "get"):
            send_file(FileName, Client)


except Exception as x:
    # Print the exception message
    print(x)

finally:
    # To close the councation
    Client.close()
