/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/24
 */
 // 5.最长回文子串
 // 方法1：暴力法
 /**
  * 1.遍历字符串，对每个位置，判断当前长度是否存在回文
  */
#include <iostream>
#include <windows.h>
 using namespace std;
 class Solution {
 public:
     string longestPalindrome(string s) {
         string rstr;
         for(int i = 0; i < s.size(); i++) {
            //判断是否存在回文
            for (int j = 0; j <= i; j++) {
                string temp = existPalindrome(j, i, s);
                if (temp.size() > rstr.size())
                    rstr = temp;
            }
         }
        return rstr;
     }
     string existPalindrome(int index1,int index2,string s){
         int i = index1, j = index2;
         bool flag = true;
         while(i < j){
             if(s[i] == s[j]){
                 i++;
                 j--;
             }else{
                 flag = false;
                 break;
             }
         }
         if(flag){//说明是回文，返回回文
             return s.substr(index1, index2-index1+1);
         }
         return "";
     }
 };

 int main(){
     Solution solution;
     DWORD start = GetTickCount();
     string s = solution.longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");
     DWORD end = GetTickCount();
     cout << s << endl << start <<endl << end<<endl;
     cout<< end-start<<endl;
 }