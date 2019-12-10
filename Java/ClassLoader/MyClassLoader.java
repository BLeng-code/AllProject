import java.io.InputStream;

class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new ClassCastException();
            }
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            return super.defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            // TODO: handle exception
            throw new ClassCastException();
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> klass = findLoadedClass(name);
            if (klass == null) {
                if (name.startsWith("java.") || name.startsWith("javax")) {
                    try {
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                } else {
                    try {
                        klass = findClass(name);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    if (klass == null) {
                        if (getParent() != null) {
                            klass = getParent().loadClass(name);
                        } else {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
                if (klass == null) {
                    throw new ClassNotFoundException();
                }
                return klass;
            }
        }
        return null;
    }

}