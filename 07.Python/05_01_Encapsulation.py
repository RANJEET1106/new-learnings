class Company():
    def __init__(self):
        self.companyName='Infosys' #public
        self.__companyName2="Edgeverve" # private
        self._companyName3="Cognizant" # protected
    def companyName2(self):
        print(self.__companyName2)
c1= Company()
c1.companyName="Google"
print(c1.companyName)
c1.companyName2()

class B(Company):
    pass

b1= B()
print(b1._companyName3)
# self.companyName ---> public
# self.__companyName ---> private
# self._companyName ---> protected

