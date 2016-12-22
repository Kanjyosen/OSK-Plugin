package jp.dip.osakanjyo;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener {
	
	Economy econ = null;
	String Player = null;
	
	int count = 0;
	@Override
	public void onEnable() {
		if(!setupEconomy()) {
			getLogger().warning("Vaultが導入されていません。ZRSK-Pluginは無効化されます。");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
	
		System.out.println("[ZRSK-Plugin]プラグインが起動しました。");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	private boolean setupEconomy(){
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if(rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	@Override
	public void onDisable() {
		System.out.println("[ZRSK-Plugin]プラグインが停止しました");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label.equalsIgnoreCase("zrsk")) {
			count++;
			System.out.println("[ZRSK-Plugin]テストコマンドが実行されました: " + count);
			//} else if (label.equalsIgnoreCase("skyhi")) {
			//if (args.length == 0) {
				//sender.sendMessage(ChatColor.RED + "[OSK-Plugin]パラメーターが足りません");
				//} else {
				//Player target = getServer().getPlayer(args[0]);
				//if (target == null) {
					//sender.sendMessage(ChatColor.RED + "[OSK-Plugin]プレイヤーが見つかりません");
					//				} else {
					//skyhi(target);
					//					sender.sendMessage(ChatColor.AQUA + "[OSK-Plugin]プレイヤー\"" + target.getDisplayName() + ChatColor.AQUA + "\"をスカイハイしました");
//				}
//			}
			
			//ここから下にコマンド用の文を追加
		} else if (label.equalsIgnoreCase("zrsk-version")) {
			sender.sendMessage(ChatColor.AQUA + "ZRSK-Plugin Powered by Densyakun v-Beta2.0(2016/12/19's update)(Densyakun-Life Server custom edition)");
		} else if (label.equalsIgnoreCase("zrsk-stuffs")) {
			sender.sendMessage(ChatColor.AQUA + "企画・細工：環状線(blog: http://kmskmp.hateblo.jp 大改造・大体の開発：電車君 twitter: https://twitter.com/Densyakun )");
		} else if (label.equalsIgnoreCase("zrsk-help")) {
			sender.sendMessage(ChatColor.AQUA + "/zrsk-stuffs ZRSK-Plugin制作陣の名前等を表示します /zrsk-version 現在導入されているZRSK-Pluginのバージョン等を表示します /server-help サーバーについて /server-trains　<駅名> パラメータに入力された番号の駅で運行している鉄道を表示します。大森線の氷川南～大森公園間にのみ対応しています。");
		} else if (label.equalsIgnoreCase("server-help")) {
			sender.sendMessage(ChatColor.AQUA + "サーバーについての詳細は、 http://densyakunserver.dip.jp をご覧ください。");
		} else if (label.equalsIgnoreCase("server-trains")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "[ZRSK-Plugin]パラメーターが足りません");
			} else if (args[0].equalsIgnoreCase("大森公園")) {
				sender.sendMessage("大森公園駅 LR大森線:大森・新高山・東島方面 みどり高速鉄道線:みどり行き");
			} else if (args[0].equalsIgnoreCase("大森")) {
				sender.sendMessage("大森駅 LR大森線:新高山・東島方面/大森公園行 LR中央線:中央方面行き/雪乃島行き");
			} else if (args[0].equalsIgnoreCase("新高山")) {
				sender.sendMessage("新高山駅 LR大森線:東島方面/大森方面 ≪カカオ豆の名産地≫");
			} else if (args[0].equalsIgnoreCase("中栗山")) {
				sender.sendMessage("中栗山駅 LR大森線:東島方面/大森方面");
			} else if (args[0].equalsIgnoreCase("火の山")) {
				sender.sendMessage("火の山駅 LR大森線:東島方面/大森方面");
			} else if (args[0].equalsIgnoreCase("砂浜")) {
				sender.sendMessage("砂浜駅 LR大森線:東島方面/大森方面 砂浜区最寄り駅");
			} else if (args[0].equalsIgnoreCase("茸島")) {
				sender.sendMessage("茸島駅 LR大森線:東島方面/大森方面");
			} else if (args[0].equalsIgnoreCase("東島")) {
				sender.sendMessage("東島駅 LR大森線:南瓜台行き/茸島方面 地下鉄東島線各駅停車:センター前方面 地下鉄東島線快速電車:氷ヶ池路行き(直行) 地下鉄南北線:明石行き");
			} else if (args[0].equalsIgnoreCase("氷川南")) {
				sender.sendMessage("氷川南駅 LR大森線 南瓜台行き/茸島方面 地下鉄東西線:南瓜台行き/氷ヶ池路方面");
			} else {
				sender.sendMessage("データベースと駅名が一致しません。未対応である場合や、駅名の「駅」を入れてしまっている場合があります。非対応の場合は、管理者を経由して開発者まで連絡してください。");
			}
		} else if (label.equalsIgnoreCase("zrsk-time")) {
			Date date = new Date();
			sender.sendMessage(ChatColor.GREEN + "本日は⇒" + new SimpleDateFormat("yyyy.MM.dd").format(date) + "ただ今の時刻⇒" + new SimpleDateFormat("kk,mm").format(date));
			//テンプレ
		//} else if (label.equalsIgnoreCase("コマンド")) {
			//(処理)
			//ここから上にコマンド用の文を追加
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void BlockPlace(BlockPlaceEvent e) {
		if (e.getBlock().getType() == Material.TNT) {
			e.getBlock().setType(Material.DIRT);
			e.getPlayer().sendMessage("[ZRSK-Plugin]TNTの設置は禁じられています。罰金20000円を徴収したうえで、設置したTNTを土に変えました。");
			String player = e.getPlayer().getName();
			EconomyResponse r = econ.withdrawPlayer(player, 20000);
			System.out.println("[警告][WARN]" + player + "によるTNTの設置を阻止しました。");
		}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEvent(BlockIgniteEvent e) {
			e.getBlock().setType(Material.DIRT);
			e.getPlayer().sendMessage("[ZRSK-Plugin]着火行為は禁じられています。罰金25000円を徴収したうえで、火を土に変えました。");
			String player = e.getPlayer().getName();
			EconomyResponse r = econ.withdrawPlayer(player, 20000);
			System.out.println("[警告][WARN]" + player + "による着火行為を阻止しました。");
		}
	}
//	@EventHandler
	//	public void PlayerInteract(PlayerInteractEvent e) {
	//		if (e.getItem() == null && e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
	//			Location location = e.getPlayer().getLocation();
	//			e.getPlayer().teleport(new Location(location.getWorld(), location.getX(), location.getY() + 5, location.getZ(), location.getPitch(), location.getYaw()));
//		} else if (e.getItem() == null && e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
//			Location location = e.getPlayer().getLocation();
//			e.getPlayer().teleport(new Location(location.getWorld(), location.getX(), location.getY() + 1, location.getZ(), location.getPitch(), location.getYaw()));
	//		}
	//	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		if (e.getPlayer().getName().equals("44SUSHI")) {
			skyhi(e.getPlayer());
		}
	}
	@EventHandler
	public void PlayerRespawn(PlayerRespawnEvent e) {
		if (e.getPlayer().getName().equals("44SUSHI")) {
			skyhi(e.getPlayer());
		}
	}
	public void skyhi(Player player) {
		Location location = player.getLocation();
		player.teleport(new Location(location.getWorld(), location.getX(), 256, location.getZ(), location.getPitch(), location.getYaw()));
	}
}
