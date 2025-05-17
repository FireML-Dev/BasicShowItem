package uk.firedev.simpleshowitem;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (item.getType().isEmpty()) {
            return;
        }
        Component hover = item.displayName();
        Component message = event.message()
            .replaceText(builder -> builder.matchLiteral("[i]").replacement(hover))
            .replaceText(builder -> builder.matchLiteral("[item]").replacement(hover));
        event.message(message);
    }

}
