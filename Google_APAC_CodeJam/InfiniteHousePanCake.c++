#include <cstdio>  
#include <cstring>  
#include <algorithm>  
using namespace std ;  
    int arr[1200] ;  
    int main() {  
        int t , step = 0 ;  
        int n , i , j , max1 , min1 , sum ;   
        scanf("%d", &t) ;  
        while( t-- ) {  
            scanf("%d", &n) ;  
            for(i = 0 ; i < n ; i++) {  
                scanf("%d", &arr[i]) ;  
                max1 = max(max1,arr[i]) ;  
            }  
            min1 = max1 ;  
            for(i = 1 ; i <= max1 ; i++) {  
                sum = i ;  
                for(j = 0 ; j < n ; j++) {  
                    if( arr[j] > i ) {  
                        if( arr[j]%i == 0 )  
                            sum += (arr[j]/i-1) ;  
                        else  
                            sum += (arr[j]/i) ;  
                    }  
                }  
                min1 = min(min1,sum) ;  
            }  
            printf("Case #%d: %d\n", ++step, min1) ;  
        }  
        return 0 ;  
    }
