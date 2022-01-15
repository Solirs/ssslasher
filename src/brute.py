from colorama import Fore
import argparse
import os

def output_text(color:Fore, text:str):
    print(color, "\r[-]", text, Fore.RESET)

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-w', help='The wordlist file path for the dictionary attack', required=True, type=str)
    parser.add_argument('-t', help='The number of threads you wish to use. The more threads used the faster \
                        but could lead to some problems and easily notify the victim.', type=int)
    return parser.parse_args()

def load_main(wordlist, thread_count):
    # the run command goes here with the args
    output_text(Fore.GREEN, "Everything was good. Loading main file...")
    os.system(f"java -jar file.jar {wordlist} {thread_count}")

if __name__ == '__main__':
    if os.name == 'nt':
        pass
    elif os.name == 'posix':
        pass

    args = parse_args()
    wordlist = args.w
    thread_count = args.t

    if not os.path.exists(wordlist): 
        output_text(Fore.RED, f"Wordlist '{wordlist}' does not exist!")
        exit()
    if not os.path.isfile(wordlist):
        output_text(Fore.RED, f"Wordlist has to be a file!")
        exit()

    if thread_count == None:
        thread_count = 1
        output_text(Fore.YELLOW, f"Thread count was not set and will automatically be {thread_count}")

    load_main(wordlist, thread_count)
