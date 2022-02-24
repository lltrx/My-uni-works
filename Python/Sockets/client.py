import socket
import sys
import os
from utility import send_file, recv_file, recv_listing


try:
    # Create the socket that will be used to connect to the server.
    Client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# The SeverIP is a tuple that contains the IP of the server, as well as the port number.
    ServerIP = (sys.argv[1], int(sys.argv[2]))

# Establish a link between the server and the client.
    Client.connect(ServerIP)

# When the client connects to the server, this massage will appear.
    print("Connected.")

    if(len(sys.argv) == 4):
        Port = sys.argv[3] + " "

    elif(len(sys.argv) == 5):
        Port = sys.argv[3] + " " + sys.argv[4]

    cmd = Port.split(" ", 1)

    if (cmd[0] == "list"):

        # To convert a string to an argument, use encoding.
        Client.sendall(str.encode(Port))
        List = recv_listing(Client)

# This is how the list will be printed.
        print(" ".join(List))

    else:
        # FileName is the name of the file to send.
        FileName = os.path.join(os.path.dirname(
            __file__), "client_data/") + cmd[1]

        if (cmd[0] == "put"):
            Client.sendall(str.encode(Port))
            send_file(FileName, Client)

        elif (cmd[0] == "get"):
            Client.sendall(str.encode(Port))
            recv_file(FileName, Client)


except Exception as x:
    # Print the exception message.
    print(x)

finally:
    # To close the councation.
    Client.close()
