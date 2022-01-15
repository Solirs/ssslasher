import argparse

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-w', help='The wordlist file path for the dictionary attack', required=True, type=str)
    parser.add_argument('-t', help='The number of threads you wish to use. The more threads used the faster \
                        but could lead to some problems and easily notify the victim.', required=True, type=int)
    return parser.parse_args()

if __name__ == '__main__':
    args = parse_args()
    wordlist = args.w
    thread_count = args.t