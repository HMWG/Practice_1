fun main(args: Array<String>) { //1018
    var num = readLine()!!.split(" ")
    var numArr = IntArray(2)
    for(i in num.indices){
        numArr[i] = num[i].toInt()
    }

    var chessArr = Array(numArr[0]){Array(numArr[1]){""} }
    var copyArr = Array(numArr[0]){Array(numArr[1]){""} }

    var count = IntArray((numArr[0]-7)*(numArr[1]-7)){0}
    var n = 0

    for(i in 0 until numArr[0]){
        var str = readLine()
        for(j in 0 until  numArr[1]){
            chessArr[i][j] = str!![j].toString()
        }
    }

    for(i in 0 until numArr[0]){
        for(j in 0 until  numArr[1]){
            copyArr[i][j] = chessArr[i][j]
        }
    }

    /*for(i in 0 until numArr[0]){
        for(j in 0 until  numArr[1]){
            print(chessArr[i][j])
        }
        println()
    }*/

    for(i in 0..numArr[0]-8){ //세로줄 반복횟수
        for(j in 0..numArr[1]-8){ //가로줄 반복횟수

            for(z in 0 until numArr[0]){
                for(x in 0 until  numArr[1]){
                    copyArr[z][x] = chessArr[z][x]
                }
            }

            for(p in i..i+6){ //세로줄 7번 비교
                for(q in j..j+6){ //가로줄 7번 비교
                    if(copyArr[p][q]==copyArr[p+1][q]){
                        if(copyArr[p+1][q]=="B"){
                            copyArr[p+1][q]="W"
                            count[n]++
                        }
                        else if(copyArr[p+1][q]=="W"){
                            copyArr[p+1][q]="B"
                            count[n]++
                        }

                    }
                    if(copyArr[p][q]==copyArr[p][q+1]){
                        if(copyArr[p][q+1]=="B"){
                            copyArr[p][q+1]="W"
                            count[n]++
                        }
                        else if(copyArr[p][q+1]=="W"){
                            copyArr[p][q+1]="B"
                            count[n]++
                        }
                    }
                }
            }

            for(i in 0 until numArr[0]){
                for(j in 0 until  numArr[1]){
                    print(copyArr[i][j])
                }
                println()
            }

            n++
        }
    }

    var min = count[0]

    for(i in count.indices){
        if(count[i]<min){
            min = count[i]
        }
    }

    print(min)

}