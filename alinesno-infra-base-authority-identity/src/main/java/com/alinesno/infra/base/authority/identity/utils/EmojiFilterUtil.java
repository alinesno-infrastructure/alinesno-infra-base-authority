package com.alinesno.infra.base.authority.identity.utils;

import org.apache.commons.lang3.StringUtils;

public class EmojiFilterUtil {

    // 更全面的 Emoji Unicode 范围
    private static final String EMOJI_PATTERN =
            "[\\x{1F600}-\\x{1F64F}" +        // Emoticons
            "\\x{1F300}-\\x{1F5FF}" +        // Symbols & Pictographs
            "\\x{1F680}-\\x{1F6FF}" +        // Transport & Map Symbols
            "\\x{1F700}-\\x{1F77F}" +        // Alchemical Symbols
            "\\x{1F780}-\\x{1F7FF}" +        // Geometric Shapes Extended
            "\\x{1F800}-\\x{1F8FF}" +        // Supplemental Arrows-C
            "\\x{1F900}-\\x{1F9FF}" +        // Supplemental Symbols and Pictographs
            "\\x{1FA00}-\\x{1FA6F}" +        // Chess Symbols
            "\\x{1FA70}-\\x{1FAFF}" +        // Symbols and Pictographs Extended-A
            "\\x{2600}-\\x{26FF}" +          // Miscellaneous Symbols
            "\\x{2700}-\\x{27BF}" +          // Dingbats
            "\\x{2B50}\\x{2B55}" +           // Stars and other symbols
            "\\x{FE0F}" +                    // Variation Selectors
            "\\x{1F1E0}-\\x{1F1FF}]";       // Flags

    /**
     * 过滤字符串中的Emoji表情
     * @param input 输入字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }
        return input.replaceAll(EMOJI_PATTERN, "");
    }

    /**
     * 检查字符串是否包含Emoji
     * @param input 输入字符串
     * @return true表示包含Emoji
     */
    public static boolean containsEmoji(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        return input.matches(".*" + EMOJI_PATTERN + ".*");
    }
}