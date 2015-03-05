package pe.gob.oefa.efa.utils;

import org.apache.commons.dbcp.BasicDataSource;

public class EncryptionAwareDataSource extends BasicDataSource {
	
	@Override
    public synchronized void setPassword(String password) {     
        try {
			super.setPassword(AESCrypt.decrypt(password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
    public synchronized void setUsername(String username) {     
        try {
			super.setUsername(AESCrypt.decrypt(username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
    public synchronized void setUrl(String url) {     
        try {
			super.setUrl(AESCrypt.decrypt(url));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
