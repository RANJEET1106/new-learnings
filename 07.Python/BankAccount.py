class BalanceException(Exception):
    pass


class BankAccount:
    def __init__(self, initial_amount, acct_name):
        self.balance = initial_amount
        self.name = acct_name

    def get_balance(self):
        print(f"Account Name: {self.name}, Balance: {self.balance:.2f}")

    def deposit(self, amount):
        self.balance += amount
        print(f"Deposited: {amount:.2f}")
        self.get_balance()

    def viable_transaction(self, amount):
        if self.balance >= amount:
            return
        else:
            raise BalanceException(
                f"Sorry, account only has a balance of: {self.balance:.2f}"
            )

    def withdraw(self, amount):
        try:
            self.viable_transaction(amount)
            self.balance -= amount
            print(f"Withdrawn: {amount:.2f}")
            self.get_balance()
        except BalanceException as e:
            print(e)




