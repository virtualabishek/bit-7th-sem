import threading
import time
import asyncio

def io_task():
    time.sleep(1)


start = time.time();
for _ in range(3):
    io_task()
print(f"Single threaded time: {time.time() - start:.2f}s")


start = time.time()
threads = [threading.Thread(target=io_task) for _ in range(3)]
for t in threads:
    t.start()

for t in threads:
    t.join()

print(f"Multi-threaded time: {time.time() - start:.2f}s")

async def asyncIo_task():
    await asyncio.sleep(1)


async def main_async():
    start = time.time()
    await asyncio.gather(asyncIo_task(), asyncIo_task(), asyncIo_task())
    print(f"Asynchronous time: {time.time() - start:.2fs}")