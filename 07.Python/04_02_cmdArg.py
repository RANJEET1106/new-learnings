import argparse
def hello(name,lang):
    greetings = {
        "English":"Hello",
        "Hindi":"Namaste",
        "Marathi":"Namaskar"
    }
    return f"{greetings[lang]}, {name}"

parser = argparse.ArgumentParser(
    description="Provides a personal greeting"
)
parser.add_argument('-n','--name',metavar="name", required=True, help="The name of the person to greet")
parser.add_argument('-l', '--lang',metavar="languages", required=True, 
                    choices=["English","Hindi","Marathi"],
                    help="Language of greeting")
args = parser.parse_args()

print(f"Hello! {args.name}")
print(hello(args.name, args.lang))