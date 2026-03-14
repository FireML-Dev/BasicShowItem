package uk.firedev.basicshowitem;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        if (!event.getPlayer().hasPermission("basicshowitem.use")) {
            return;
        }
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Component hover = buildHover(item);
        Component message = event.message()
            .replaceText(builder -> builder.matchLiteral("[i]").replacement(hover))
            .replaceText(builder -> builder.matchLiteral("[item]").replacement(hover));
        event.message(message);
    }

    private Component buildHover(@NotNull ItemStack item) {
        if (item.isEmpty()) {
            return Component.text("[Air]");
        }
        return Component.text()
            .append(Component.text("["))
            .append(retrieveDisplayName(item))
            .append(Component.text("]"))
            .hoverEvent(item)
            .build();
    }

    private Component retrieveDisplayName(@NotNull ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return Component.text("Air");
        }
        Component display = meta.displayName();
        return display == null ? Component.translatable(item) : display;
    }

}
