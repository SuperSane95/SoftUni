from urllib.parse import urlparse

file_name = input()

path_time_dict = {}

with open(file_name) as f:
    for line in f.readlines():
        data = line.split(' ')
        url = data[4]
        url = url.replace('url=', '')
        url = url.replace('"', '')
        url = urlparse(url)
        url = url.path
        resp_time = data[-2].replace('resp_t=','')
        resp_time = resp_time.replace('"','')
        resp_time = float(resp_time)
        url_data = str(url).split('/')
        if 'ws' not in url_data:
            if url in path_time_dict:
                temp_list = path_time_dict[url]
                new_time = resp_time+temp_list[0]
                new_count = temp_list[1] + 1
                path_time_dict[url] = [new_time, new_count]
            else:
                path_time_dict[url] = [resp_time, 1]

    min_time = 0.0
    slowest_path = ''
    for key, val in path_time_dict.items():
        temp_time = val[0]/val[1]
        if temp_time > min_time:
            min_time = temp_time
            slowest_path = key

    print(slowest_path)
    print('{:.3f}'.format(min_time))

