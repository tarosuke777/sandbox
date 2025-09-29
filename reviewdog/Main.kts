import java.io.File

fun main() {
    val targetDirectory = File("./test")
    val report = File("./result.txt")
    report.createNewFile()
    val keyword = "TODO"

    targetDirectory
        .walk() // フォルダ内の全ファイルとディレクトリを走査します
        .filter { it.isFile } // ファイルだけを対象とします
        .forEach { file ->
            // ファイルの各行を走査します
            file.readLines().forEachIndexed { index, line ->
                // 特定のキーワードが含まれている行を出力します
                if (line.contains(keyword)) {
                    report.appendText("${file.path}:${index + 1}:1:i: :warning: :x: TODO found \ntwo line\nthree line\n")
                }
            }
        }
}

main()
