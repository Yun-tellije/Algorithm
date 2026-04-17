-- 코드를 입력하세요
SELECT concat("/home/grep/src/", f.board_id, '/', f.file_id, f.file_name, f.file_ext) file_path
from used_goods_file AS f
join used_goods_board AS b
    ON f.board_id = b.board_id
where b.views = (
    SELECT MAX(views)
    FROM used_goods_board
)
order by f.file_id desc;
