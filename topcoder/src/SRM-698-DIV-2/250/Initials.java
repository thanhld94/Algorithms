
// {{{ VimCoder 0.3.6 <-----------------------------------------------------
// vim:filetype=java:foldmethod=marker:foldmarker={{{,}}}

import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;

// }}}

public class Initials
{
	public String getInitials(String name)
	{
    String[] words = name.split(" ");
    String result = "";
    for (String word : words) {
      result += word.charAt(0);
    }
    return result;
	}
}

