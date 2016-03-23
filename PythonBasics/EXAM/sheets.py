import sys

try:
    sheet_size = float(input())
    vis = float(input())
    shir = float(input())
    dulb = float(input())
except Exception as e:
    print('INVALID INPUT')
    sys.exit()


full_size = 2*dulb*vis + 2*dulb*shir + 2*vis*shir
SHEET_LOSS = 9.8/100
full_size += full_size * SHEET_LOSS

sheets_count = 0

sheets_count = full_size / sheet_size

floating_part = sheets_count % 1
if floating_part > 0:
    sheets_count += 1

sheets_count = int(sheets_count)
print(sheets_count)


