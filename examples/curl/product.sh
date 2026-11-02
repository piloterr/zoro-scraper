#!/usr/bin/env bash
# Zoro Product API – cURL example
# Usage: PILOTERR_API_KEY=your-key ./product.sh
set -euo pipefail

curl -sS --fail-with-body -G "https://api.piloterr.com/v2/zoro/product" \
  -H "x-api-key: ${PILOTERR_API_KEY}" \
  --data-urlencode query=https://www.zoro.com/3m-safety-glasses-securefit-200-series-scotchgard-anti-fog-frameless-blue-temples-clear-lens-sf201sgaf-blu/i/G1937045/
