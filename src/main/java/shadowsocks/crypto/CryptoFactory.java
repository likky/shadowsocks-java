/*   
 *   Copyright 2016 Author:NU11 bestoapache@gmail.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package shadowsocks.crypto; 

import shadowsocks.crypto.CryptoException;
import shadowsocks.crypto.AESCrypto;
import shadowsocks.crypto.Chacha20Crypto;
import shadowsocks.crypto.SSCrypto;

public class CryptoFactory{

    private static final String AES = "aes";
    private static final String CHACHA20 = "chacha20";

    public static SSCrypto create(String name, String password) throws CryptoException
    {
        String cipherName = name.toLowerCase();
        if (cipherName.startsWith(AES)) {
            return new AESCrypto(name, password);
        }else if (cipherName.startsWith(CHACHA20)) {
            return new Chacha20Crypto(name, password);
        }else{
            throw new CryptoException("Unsupport method: " + name);
        }
    }
}
