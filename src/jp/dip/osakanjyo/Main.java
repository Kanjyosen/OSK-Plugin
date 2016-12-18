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
			getLogger().warning("Vault����������Ă��܂���BZRSK-Plugin�͖���������܂��B");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
	
		System.out.println("[ZRSK-Plugin]�v���O�C�����N�����܂����B");
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
		System.out.println("[ZRSK-Plugin]�v���O�C������~���܂���");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label.equalsIgnoreCase("zrsk")) {
			count++;
			System.out.println("[ZRSK-Plugin]�e�X�g�R�}���h�����s����܂���: " + count);
			//} else if (label.equalsIgnoreCase("skyhi")) {
			//if (args.length == 0) {
				//sender.sendMessage(ChatColor.RED + "[OSK-Plugin]�p�����[�^�[������܂���");
				//} else {
				//Player target = getServer().getPlayer(args[0]);
				//if (target == null) {
					//sender.sendMessage(ChatColor.RED + "[OSK-Plugin]�v���C���[��������܂���");
					//				} else {
					//skyhi(target);
					//					sender.sendMessage(ChatColor.AQUA + "[OSK-Plugin]�v���C���[\"" + target.getDisplayName() + ChatColor.AQUA + "\"���X�J�C�n�C���܂���");
//				}
//			}
			
			//�������牺�ɃR�}���h�p�̕���ǉ�
		} else if (label.equalsIgnoreCase("zrsk-version")) {
			sender.sendMessage(ChatColor.AQUA + "ZRSK-Plugin Powered by Densyakun v-Beta2.0(2016/12/19's update)(Densyakun-Life Server custom edition)");
		} else if (label.equalsIgnoreCase("zrsk-stuffs")) {
			sender.sendMessage(ChatColor.AQUA + "���E�׍H�F���(blog: http://kmskmp.hateblo.jp ������E��̂̊J���F�d�ԌN twitter: https://twitter.com/Densyakun )");
		} else if (label.equalsIgnoreCase("zrsk-help")) {
			sender.sendMessage(ChatColor.AQUA + "/zrsk-stuffs ZRSK-Plugin����w�̖��O����\�����܂� /zrsk-version ���ݓ�������Ă���ZRSK-Plugin�̃o�[�W��������\�����܂� /server-help �T�[�o�[�ɂ��� /server-trains�@<�w��> �p�����[�^�ɓ��͂��ꂽ�ԍ��̉w�ŉ^�s���Ă���S����\�����܂��B��X���̕X���`��X�����Ԃɂ̂ݑΉ����Ă��܂��B");
		} else if (label.equalsIgnoreCase("server-help")) {
			sender.sendMessage(ChatColor.AQUA + "�T�[�o�[�ɂ��Ă̏ڍׂ́A http://densyakunserver.dip.jp ���������������B");
		} else if (label.equalsIgnoreCase("server-trains")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "[ZRSK-Plugin]�p�����[�^�[������܂���");
			} else if (args[0].equalsIgnoreCase("��X����")) {
				sender.sendMessage("��X�����w LR��X��:��X�E�V���R�E�������� �݂ǂ荂���S����:�݂ǂ�s��");
			} else if (args[0].equalsIgnoreCase("��X")) {
				sender.sendMessage("��X�w LR��X��:�V���R�E��������/��X�����s LR������:�������ʍs��/��T���s��");
			} else if (args[0].equalsIgnoreCase("�V���R")) {
				sender.sendMessage("�V���R�w LR��X��:��������/��X���� ��J�J�I���̖��Y�n��");
			} else if (args[0].equalsIgnoreCase("���I�R")) {
				sender.sendMessage("���I�R�w LR��X��:��������/��X����");
			} else if (args[0].equalsIgnoreCase("�΂̎R")) {
				sender.sendMessage("�΂̎R�w LR��X��:��������/��X����");
			} else if (args[0].equalsIgnoreCase("���l")) {
				sender.sendMessage("���l�w LR��X��:��������/��X���� ���l��Ŋ��w");
			} else if (args[0].equalsIgnoreCase("����")) {
				sender.sendMessage("�����w LR��X��:��������/��X����");
			} else if (args[0].equalsIgnoreCase("����")) {
				sender.sendMessage("�����w LR��X��:��Z��s��/�������� �n���S�������e�w���:�Z���^�[�O���� �n���S�����������d��:�X���r�H�s��(���s) �n���S��k��:���΍s��");
			} else if (args[0].equalsIgnoreCase("�X���")) {
				sender.sendMessage("�X���w LR��X�� ��Z��s��/�������� �n���S������:��Z��s��/�X���r�H����");
			} else {
				sender.sendMessage("�f�[�^�x�[�X�Ɖw������v���܂���B���Ή��ł���ꍇ��A�w���́u�w�v�����Ă��܂��Ă���ꍇ������܂��B��Ή��̏ꍇ�́A�Ǘ��҂��o�R���ĊJ���҂܂ŘA�����Ă��������B");
			}
		} else if (label.equalsIgnoreCase("zrsk-time")) {
			Date date = new Date();
			sender.sendMessage(ChatColor.GREEN + "�{���́�" + new SimpleDateFormat("yyyy.MM.dd").format(date) + "�������̎�����" + new SimpleDateFormat("kk,mm").format(date));
			//�e���v��
		//} else if (label.equalsIgnoreCase("�R�}���h")) {
			//(����)
			//���������ɃR�}���h�p�̕���ǉ�
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void BlockPlace(BlockPlaceEvent e) {
		if (e.getBlock().getType() == Material.TNT) {
			e.getBlock().setType(Material.DIRT);
			e.getPlayer().sendMessage("[ZRSK-Plugin]TNT�̐ݒu�͋ւ����Ă��܂��B����20000�~�𒥎����������ŁA�ݒu����TNT��y�ɕς��܂����B");
			String player = e.getPlayer().getName();
			EconomyResponse r = econ.withdrawPlayer(player, 20000);
			System.out.println("[�x��][WARN]" + player + "�ɂ��TNT�̐ݒu��j�~���܂����B");
		}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEvent(BlockIgniteEvent e) {
			e.getBlock().setType(Material.DIRT);
			e.getPlayer().sendMessage("[ZRSK-Plugin]���΍s�ׂ͋ւ����Ă��܂��B����25000�~�𒥎����������ŁA�΂�y�ɕς��܂����B");
			String player = e.getPlayer().getName();
			EconomyResponse r = econ.withdrawPlayer(player, 20000);
			System.out.println("[�x��][WARN]" + player + "�ɂ�钅�΍s�ׂ�j�~���܂����B");
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
