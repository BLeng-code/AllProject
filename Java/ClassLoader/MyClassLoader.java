import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String classpath;

    public MyClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("子类查找");
        byte[] bytes = getBytesCodeFormPath(name);
        if (bytes != null) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
        return super.findClass(name);
    }

    private byte[] getBytesCodeFormPath(String className) {
        String path = classpath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream in = new FileInputStream(path);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffers = new byte[2048];
            int len = 0;
            while ((len = in.read(buffers)) != -1) {
                out.write(buffers, 0, len);
            }
            return out.toByteArray();
        } catch (Exception ex) {
            // NOOP
            ex.printStackTrace();
        }
        return null;
    }
}