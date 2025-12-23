#!/usr/bin/env sh
# wait-for.sh -- wait for a TCP host/port to become available
set -e

host="$1"
shift
port="$1"
shift

echo "Waiting for ${host}:${port}..."

until nc -z "$host" "$port"; do
  >&2 echo "Service ${host}:${port} is unavailable - sleeping"
  sleep 1
done

>&2 echo "Service ${host}:${port} is up"
exec "$@"
