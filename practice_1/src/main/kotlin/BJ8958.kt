import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()){
        var token = StringTokenizer(br.readLine())
        var a = token.nextToken().split("")
        var sum = 0
        var n = 1
        sum = if(a[1]=="O"){
            1
        } else{
            0
        }

        for (i in 2..a.size-2){
            if(a[i]=="X"){
                n = 1
            }
            else if(a[i]=="O"){
                if(a[i-1]=="O"){
                    n++
                    sum += n
                }
                else if(a[i-1]=="X"){
                    sum += n
                }
            }
        }
        bw.write("${sum}\n")
    }
    bw.flush()
    bw.close()
}