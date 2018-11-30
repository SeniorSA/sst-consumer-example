LOCK TABLE integration IN ACCESS EXCLUSIVE MODE;
update integration set preview_send_date = send_date where (send_date is not null);
update integration set preview_send_date = to_timestamp(to_char(scheduled_date, 'YYYY-MM-DD  00:00:00'), 'YYYY-MM-DD  00:00:00') where (send_date is null and scheduled_date is not null);