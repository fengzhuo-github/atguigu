package test;


import javax.print.DocFlavor;
import java.io.File;
public class RenameFile {

    //递归删除所有带后缀的及错误文件
    public static void delSuffix(File file){
        if (file.isFile()){
            String fileName = file.getName().toLowerCase();
            if (fileName.contains("y9000x") || fileName.contains("desktop") || fileName.endsWith("ioerr") ){
                file.delete();
            }
        } else {
            File[] all = file.listFiles();
            for (File f : all){
                delSuffix(f);
                
            }
        }
    }

    //递归重命名所有要保留的后缀
    public static void renameSuffix(File file, String suffixSave, String suffixDel){
        if (file.isDirectory()){
            File[] all = file.listFiles();
            for (File f : all){
                if (f.isFile() ){
                    if (f.getName().contains(suffixSave)){
                        File delFile = new File(f.getName().replace(suffixSave,""));
                        delFile.delete();
                        file.renameTo(delFile);
                    }else if (f.getName().contains(suffixDel)){
                        f.delete();
                    }else if (f.getName().endsWith("IOErr")){
                        f.delete();
                    }
                } else{
                    renameSuffix(f,suffixSave,suffixDel);
                }
            }
        }
    }


    public static void main(String[] args) {
        File file = new File(args[0]);
        new File("C:\\Users\\fengzhuo\\OneDrive\\Tencent Files\\1107428050");
        if (Integer.parseInt(args[1]) == 0 ){
            delSuffix(file);
        } else {
            if ("y9000x".equals(args[2].toLowerCase())){
                renameSuffix(file,"-Lenovo-y9000x","-DESKTOP-8HE5KIB");
            } else {
                renameSuffix(file,"-DESKTOP-8HE5KIB","-Lenovo-y9000x");
            }
        }
    }
}
