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
    parser.add_argument('-u', help='Username of the account', required=True, type=str, default="root")
    parser.add_argument('-i', help='IP', required=True, type=str)
    parser.add_argument('-p', help='Port', required=False, type=int, default=22)
    parser.add_argument('-ti', help='Timeout', required=False, type=int, default=200)
    parser.add_argument('-v', help='Verbose mode', required=False, type=bool, default=False)
    parser.add_argument('-t', help='The number of threads you wish to use. The more threads used the faster \
                        but could lead to some problems and easily notify the victim.', type=int, default=1)
    return parser.parse_args()

def load_main(ip, port, username, wordlist, thread_count, verbose_mode, timeout):
    # the run command goes here with the args
    output_text(Fore.GREEN, "Everything was good. Loading main file...")
    os.system(f"java -jar sshbrutewj.jar {ip} {port} {username} {wordlist} {thread_count} {verbose_mode} {timeout}")

if __name__ == '__main__':
    if os.name == 'nt':
        output_text(Fore.RED, "Suport for windows will be in the future")  
        exit()

    if len(sys.argv) == 1:
        credits()
    args = parse_args()
    wordlist = args.w
    thread_count = args.t
    ip_addr = args.i
    port = args.p 
    user = args.u
    verbose = args.v
    timeout = args.ti
    if not os.path.exists(wordlist): 
        output_text(Fore.RED, f"Wordlist '{wordlist}' does not exist!")
        exit()
    if not os.path.isfile(wordlist):
        output_text(Fore.RED, f"Wordlist has to be a file!")
        exit()

    if thread_count == None:
        output_text(Fore.YELLOW, f"Thread count was not set and will automatically be {thread_count}")

    load_main(ip_addr, port, user, wordlist, thread_count, verbose, timeout)