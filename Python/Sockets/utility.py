import socket
import os

# Orders a list from the server with this method.


def send_listing(s):
    for file in os.listdir(os.path.join(os.path.dirname(__file__), "server_data/")):
        s.sendall(str.encode(file))
    print("List sent to The Client")
    s.close()
    return

# To deliver the list to the client, use this method.


def recv_listing(s):
    List = []

    while True:
        data = s.recv(1024)
        List.append(data.decode())
        if not data:
            break
        print("List received from The Server")
        s.close()
        return List

# This function uploads a file to the server, taking the file from client data and sending it to server data.


def send_file(FileName, s):

    if("client_data/" in FileName):
        SearchedFile = FileName.replace("client_data/", " ")

    elif("server_data/" in FileName):
        SearchedFile = FileName.replace("server_data/", " ")

    exist = False

    print("File Name: " + SearchedFile)

    for File in os.listdir(os.path.join(os.path.dirname(__file__), "client_data/")):
        if (SearchedFile == File):
            exist = True
            break

        if(not exist):
            with open(FileName, 'rb') as f:
                for data in f:
                    s.sendall(data)
            print("File sent successfully")

        else:
            raise Exception("Failed : OverWriting existing file")

        s.close()
        return

# Get/download a file from the server with this method, which takes a file from server data and sends it to server data.


def recv_file(FileName, s):
    with open(FileName, 'wb') as f:
        while True:
            d = s.recv(1024)

            if not d:
                break

            f.write(d)
    f.close()
    print("File received successfully")

    s.close()
    return
