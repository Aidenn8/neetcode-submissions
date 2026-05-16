class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        mps = {}
        mpt = {}

        if len(s) != len(t):
            return False
        
        for i in range(len(s)):
            if s[i] not in mps:
                mps[s[i]] = 1
            else:
                mps[s[i]] += 1
            if t[i] not in mpt:
                mpt[t[i]] = 1
            else:
                mpt[t[i]] +=1
        
        return mps == mpt
            
        
        

