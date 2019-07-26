
package com.company;


public class malicTranslator extends  translator
{
    public malicTranslator(String wd)
    {
        super("http://lab.malic.xyz/dict/query.php?q="+wd);
        apiResource="lab.malic.xyz/dict";
    }
    void parser()
    {
        meaning=wbpageCtx;
    }
}
