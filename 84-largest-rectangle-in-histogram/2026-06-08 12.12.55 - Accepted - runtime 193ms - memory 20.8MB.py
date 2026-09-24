
class Solution(object):
    def largestRectangleArea(self, heights):
        stack = []
        max_area = 0
        i = 0
        n = len(heights)

        while i < n:
            if not stack or heights[stack[-1]] <= heights[i]:
                stack.append(i)
                i += 1
            else:
                top = stack.pop()
                width = i if not stack else i - stack[-1] - 1
                max_area = max(max_area, heights[top] * width)

        while stack:
            top = stack.pop()
            width = n if not stack else n - stack[-1] - 1
            max_area = max(max_area, heights[top] * width)

        return max_area
        