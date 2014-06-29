package me.libraryaddict.Chat;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.Map;

public class ChatChannel {
    private String channelFormat;
    private String channelSpyFormat;
    private String channelName;
    private String channelPermissionHear;
    private String channelPermissionJoin;
    private String channelPermissionLeave;
    private int chatRadius = -1;
    private boolean crossServer;
    private boolean useDisplayNames;
    public List<Map<?, ?>> channelTitles;

    public ChatChannel(ConfigurationSection config) {
        channelName = config.getName();
        channelPermissionHear = config.getString("PermissionToHear");
        channelPermissionJoin = config.getString("PermissionToJoin");
        channelPermissionLeave = config.getString("PermissionToLeave");
        channelFormat = config.getString("Format");
        channelSpyFormat = config.getString("SpyFormat");
        if (channelFormat != null)
            channelFormat = ChatColor.translateAlternateColorCodes('&',
                    channelFormat.replace("%Name%", "%1$1s").replace("%Message%", "%2$1s"));
        useDisplayNames = config.getBoolean("DisplayNames");
        crossServer = config.getBoolean("CrossServer", true);
        chatRadius = config.getInt("Radius", -1);
        if (chatRadius >= 0) {
            crossServer = false;
        }
        channelTitles = config.getMapList("Titles");
    }

    @SuppressWarnings("UnusedDeclaration")
    public boolean equals(ChatChannel channel) {
        return channel.getName().equals(getName());
    }

    public String getFormat() {
        return channelFormat;
    }

    public String getSpyFormat() { return channelSpyFormat; }

    public String getName() {
        return channelName;
    }

    public String getPermissionToHear() {
        return channelPermissionHear;
    }

    public String getPermissionToJoin() {
        return channelPermissionJoin;
    }

    public String getPermissionToLeave() {
        return channelPermissionLeave;
    }

    public int getRadius() {
        return chatRadius;
    }

    public boolean isCrossServer() {
        return crossServer;
    }

    public boolean useDisplayNames() {
        return useDisplayNames;
    }

    public boolean useHearPermission() {
        return channelPermissionHear != null;
    }

    public boolean useJoinPermission() {
        return channelPermissionJoin != null;
    }

    public boolean useLeavePermission() {
        return channelPermissionLeave != null;
    }

}
