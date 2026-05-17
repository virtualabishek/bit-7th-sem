import threading
import time 

def print_numbers():
    for i in range(1,6):
        time.sleep(0.1)
        print(f"{threading.current_thread().name}: {i}")


t1 = threading.Thread(target=print_numbers, name="Thread - 1")
t2 = threading.Thread(target=print_numbers, name="Thread - 2")


t1.start();
t2.start();

t1.join();
t2.join();


print("Execution copleted....")