class Solution {
  public:
    string addtwostring(string &s1, string &s2) {
      
      int n=s1.size();
      int m=s2.size();
    
      if(s1.empty()){
          
          return s2;
      }
      
      if(s2.empty()){
          
          return s1;
      }
   
      reverse(s1.begin(),s1.end());
      
      reverse(s2.begin(),s2.end());
      
      
      string res="";
      
      int i=0;
      int j=0;
      
      int carry=0;
      
      
      while(i<n || j<m || carry){
          
          
          int digit1=0,digit2=0;
          
          if(i<n)
          {
          digit1=(s1[i]-'0')%10;
          i++;
          
          }
          
          
        
           if(j<m){
             digit2=(s2[j]-'0')%10; 
              
              j++;
          }
        
          
          int sum=(digit1+digit2+carry)%10;
          
          carry=(digit1+digit2+carry)/10;
          
          
          
          res.push_back(sum+'0');
              
         
      }
      
      
      reverse(res.begin(),res.end());
      
      
      int k=res.size();
      
      i=0;
      
      while(i<=k ){
          
          if(res[i]!='0'){
              
              break;
          }
          
          else
          i++;
          
          
      }
      
     
      return res.substr(i,res.size());
     
    }
    string minSum(vector<int> &arr) {
        // code here
          sort(arr.begin(), arr.end());
        string s, t;
        
        for (int i = 0; i < arr.size(); ++i) {
            
            if (i % 2 == 0)
            
                s += to_string(arr[i]);
            else
                t += to_string(arr[i]);
        }
        return  addtwostring(s, t);
    }
};