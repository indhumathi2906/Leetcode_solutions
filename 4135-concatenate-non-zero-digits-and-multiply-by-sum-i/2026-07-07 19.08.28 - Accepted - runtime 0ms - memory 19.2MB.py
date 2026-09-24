class Solution:
    def sumAndMultiply(self, n: int) -> int:
        x=0
        digit_sum=0
        place=1
        while n>0:
            digit=n%10
            if digit!=0:
                digit_sum+=digit
                x+=digit*place
                place*=10
            n//=10
        return x*digit_sum
        