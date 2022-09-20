package enterenabler.me.nyaneo.fucking.enabling.Me.nyaneo.fucking;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class enabling extends JavaPlugin implements Listener {


    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        config.options().copyDefaults(true);
        saveConfig();


    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String pname = p.getName();
        if (!getConfig().contains(pname)){
            p.kickPlayer(config.getString("kick-message"));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("d4fdgh-fystte-ausbf-onlyadmin-api-true-set")) {
            if (sender.isOp()) {
                if (args.length == 1) {
                    config.set(args[0], "can");
                    this.saveConfig();
                    sender.sendMessage(ChatColor.GREEN + args[0] + ChatColor.AQUA + "님은 이제 우리 서버의 일원입니다!");

                }
            } else {
                sender.sendMessage(config.getString("notOp-ErrorMessage"));

            }
        }


        if (cmd.getName().equalsIgnoreCase("d4fdgh-fystte-ausbf-onlyadmin-api-true-unset")) {

            if (sender.isOp()) {
                if (args.length == 1) {
                    config.set(args[0], null);
                    this.saveConfig();

                    sender.sendMessage(ChatColor.GREEN + args[0] + ChatColor.AQUA + "님을 접속 가능 유저 컨피그 항목에서 삭제 했습니다!");
                } } else {
                    sender.sendMessage(config.getString("notOp-ErrorMessage"));

            }
        }






        return false;
    }

    @Override
    public void onDisable() {
        config.options().copyDefaults(true);
        saveConfig();
    }
}
