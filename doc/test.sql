show tables;
desc chapter_info;
desc anime_info;

select *
from anime_info;
insert into anime_info(UUID, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag,
                       indexes, update_info,
                       coverimg_src) VALUE ('UUID2', '陈子文的早晨', '[类型1,类型2]', '这是陈子文一天的描述', '陈子文の早晨', '[地区1]',
                                            '2020', '[标签1,标签2]', '陈子文早晨的索引', '每周一更新', '这是一个路径');

select *
from anime_info
where anime_type like '%类型1%'
  and anime_zone like '%地区2%'
  and anime_tag like '%%';

insert into anime_zone(uuid, zone_name) value ('UUID','湖北');
insert into anime_zone(uuid, zone_name) value ('UUID2','湖南');
insert into anime_zone(uuid, zone_name) value ('UUID3','日本');